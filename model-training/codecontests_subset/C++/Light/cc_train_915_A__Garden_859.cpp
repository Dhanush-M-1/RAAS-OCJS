#include <bits/stdc++.h>
int main() {
  int result = 0, min = 1e9;
  int buckets = 0, length = 0;
  scanf(" %d %d", &buckets, &length);
  if (buckets < 1 || length > 100) {
    return EXIT_FAILURE;
  }
  int a[buckets], maxdiv[buckets];
  for (int i = 0; i < buckets; ++i) {
    scanf("%d", &a[i]);
  }
  for (int i = 0; i < buckets; ++i) {
    if (length % a[i] == 0) {
      maxdiv[i] = length / a[i];
    } else {
      maxdiv[i] = 700;
    }
  }
  for (int i = 0; i < buckets; ++i) {
    min = min < maxdiv[i] ? min : maxdiv[i];
  }
  printf("%d\n", min);
  return EXIT_SUCCESS;
}
