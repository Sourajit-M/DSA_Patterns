def main():
    arr = [2, 5, 1, 8, 4, 0, 10]
    print(f"Before sorting: {arr}")
    quick_sort(arr, 0, len(arr)-1)
    print(f"After sorting: {arr}")

def quick_sort(arr, start, end):
    if start < end:
        part = partition(arr, start, end)

        quick_sort(arr, start, part-1)
        quick_sort(arr, part+1, end)

def partition(arr, start, end):
    pivot = arr[end]
    i = start - 1

    for j in range(start, end):
        #less than pivot
        if arr[j] < pivot:
            i += 1
        
    
