def qsort(data)
  stack = []
  stack.push(data)
  result = []

  while stack.length > 0 do
    p target = stack.pop
    p pivot = target.first
    p left = target.select {|v| v < pivot }
    p right = target.select {|v| v > pivot }

    if left.length > 1
      stack.push(left)
    end

    if right.length > 1
      stack.push(right)
    end

    if right.length == 1 && left.length == 1
      result.unshift(right.first)
      result.unshift(pivot)
      result.unshift(left.first)
    else
      if right.length == 1
        result.unshift(right.first)
        result.unshift(pivot)
      end
      if left.length == 1
        result.unshift(pivot)
        result.unshift(left.first)
      end
    end

    p result

    puts "aaaaaaaaa"

    sleep 1
  end

  result
end

# p qsort([3,2,5,4,1,2])
p qsort([8,2,5,3,9,7,4,6])
# 入力値: [3,2,5,4,1,2]
# 出力値: [1,2,2,3,4,5]
