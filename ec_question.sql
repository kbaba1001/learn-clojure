-- 1) 一度も商品を購入していないユーザーの一覧を作成してください。
select users.*
from
  users
  left join purchases
  on users.id = purchases.user_id
where
  purchases.user_id is null;

-- 2) ユーザー毎にその人が一番買っている商品の一覧を作成してください。
-- ユーザーが購入した商品の数量は purchases テーブルの quantity カラムを見るとわかります。
with
sum_quantity AS (
select
  user_id
  ,item_id
  ,SUM(quantity) as quantity
from
  purchases
group by
  user_id
  ,item_id
)
,max_quantity AS (
  select
    a.user_id
    ,item_id
    ,quantity
  from
    sum_quantity AS a
    inner join
    (
      select
        user_id
        ,max(quantity) max_quantity
      from
        sum_quantity
      group by
        user_id
    ) AS b
    on a.user_id = b.user_id
    and quantity = b.max_quantity
)
select
  users.name
  ,items.name
  ,max_quantity.quantity
from
  max_quantity
  inner join
    users
  on max_quantity.user_id = users.id
  inner join
    items
  on max_quantity.item_id = items.id
;

-- 3)
-- 商品の売れている数量が多い順のランキングを作成してください。
-- 数量が同じ商品は同じ順位にしてください。
