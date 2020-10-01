def qsort(data)
  left_stack = [0]
  right_stack = [(data.length - 1)]
  ptr = 1
  while ptr > 0 do
    ptr -= 1
    pleft = left = left_stack[ptr]
    pright = right = right_stack[ptr]
    pivot = data[(pleft + pright) / 2]

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
      left_stack[ptr] = left
      right_stack[ptr] = pright
      ptr += 1
    end
    if (pleft < right)
      left_stack[ptr] = pleft
      right_stack[ptr] = right
      ptr += 1
    end
  end

  data
end

p qsort([3,2,5,4,1,2])
# 入力値: [3,2,5,4,1,2]
# 出力値: [1,2,2,3,4,5]
