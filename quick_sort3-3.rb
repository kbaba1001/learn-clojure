def qsort(data)
  stack = []
  stack.push(data)
  result = []

  while !stack.empty? do
    sleep 1
    puts "aaaaaaaaaaaaaaa"
    p target = stack.pop
    p pivot = target.first
    p rest = target[1..-1]
    p left = rest.select {|v| v < pivot }
    p right = rest.select {|v| v >= pivot }
    p result

    if left.empty? && right.empty?
      result.unshift(pivot)
      next
    end

    if left.empty?
      stack.push([pivot])
      stack.push(right)
      next
    end

    if right.empty?
      stack.push(left)
      stack.push([pivot])
      next
    end

    stack.push(left)
    stack.push([pivot])
    stack.push(right)
  end

  result
end

p qsort([3,2,5,4,1,2])
# p qsort([8,2,5,3,9,7,4,6])
# 入力値: [3,2,5,4,1,2]
# 出力値: [1,2,2,3,4,5]
