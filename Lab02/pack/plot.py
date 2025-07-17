import matplotlib.pyplot as plt

# Sample input sizes
input_sizes = [100_000, 200_000, 300_000, 400_000, 500_000, 600_000, 700_000, 800_000, 900_000, 1_000_000]

# Sample runtimes in milliseconds (replace with real data)
runtime_A = [100, 200, 300, 400, 500, 600, 700, 800, 900, 1000]            # O(n)
runtime_B = [130, 290, 470, 680, 920, 1190, 1490, 1810, 2150, 2500]        # O(n log n)
runtime_C = [90, 350, 780, 1400, 2200, 3200, 4400, 5800, 7400, 9200]       # O(n^2)

# Plotting
plt.figure(figsize=(10, 6))
plt.plot(input_sizes, runtime_A, marker='o', label='Algorithm A (O(n))')
plt.plot(input_sizes, runtime_B, marker='s', label='Algorithm B (O(n log n))')
plt.plot(input_sizes, runtime_C, marker='^', label='Algorithm C (O(n²))')

plt.title('Runtime Comparison of Three Algorithms')
plt.xlabel('Input Size (n)')
plt.ylabel('Runtime (ms)')
plt.grid(True)
plt.legend()
plt.tight_layout()
#export to PNG/PDF using plt.savefig('filename.png')
plt.show()