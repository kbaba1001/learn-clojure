def qsort(data)
  stack = [[0, (data.length - 1)]]
  while stack.length > 0 do
    left, right = stack.pop
    pleft = left
    pright = right
    # pivot = data[(pleft + pright) / 2]
    pivot = data[0]

    # pivotの入れ替え
    x1 = data[pleft]
    x2 = data[pright]
    if (pivot <= x1 && x1 <= x2) || (x2 <= x1 && x1 <= pivot)
      pivot = x1
    end
    if (pivot <= x2 && x2 <= x1)||(x1 <= x2 && x2 <= pivot)
      pivot = x2
    end

    loop do
      while data[pleft] < pivot do
        pleft += 1
      end
      while data[pright] > pivot do
        pright -= 1
      end
      if (pleft <= pright)
        tmp = data[pleft]
        data[pleft] = data[pright]
        data[pright] = tmp
        pleft += 1
        pright -= 1
      end

      break if pleft <= right
    end
    if (left < pright)
      stack.push([left, pright])
    end
    if (pleft < right)
      stack.push([pleft, right])
    end
  end

  data
end

p qsort([3,2,5,4,1,2])
# 入力値: [3,2,5,4,1,2]
# 出力値: [1,2,2,3,4,5]
