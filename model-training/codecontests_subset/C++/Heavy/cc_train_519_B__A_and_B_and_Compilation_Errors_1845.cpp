#include <bits/stdc++.h>
int find(long long *dic, long long vl, int size) {
  int first = 0, last = size;
  while (first < last) {
    int m = first + (last - first) / 2;
    if (dic[m] >= vl)
      last = m;
    else
      first = m + 1;
  }
  return dic[last] == vl ? last : -1;
}
int main() {
  long long n, dic[100001], s[100001], temp;
  long long zip[100001], pos = 0, k;
  int flag[100001];
  scanf("%ld64", &n);
  for (int i = 0; i < n; i++) {
    scanf("%ld64", &dic[i]);
    s[i] = 0;
  }
  std::sort(dic, dic + n);
  temp = dic[0];
  zip[0] = temp;
  s[0] = 1;
  for (int i = 1; i < n; i++) {
    if (dic[i] == temp)
      s[pos]++;
    else {
      s[++pos] = 1;
      temp = dic[i];
      zip[pos] = temp;
    }
  }
  long long mm[100001];
  for (int i = 0; i < n - 1; i++) {
    scanf("%ld64", &k);
    int ind = find(zip, k, pos);
    mm[ind] += k;
    flag[ind] = 1;
  }
  int in = -1;
  for (int i = 0; i < pos + 1; i++) {
    if (mm[i] / s[i] != zip[i]) {
      printf("%d\n", zip[i]);
      in = i;
      break;
    }
  }
  for (int i = 0; i < n - 2; i++) {
    scanf("%ld64", &k);
    int ind = find(zip, k, pos);
    mm[ind] += k;
    flag[ind] = 2;
  }
  bool des = false;
  for (int i = 0; i < pos + 1; i++) {
    if (in == i) continue;
    if ((mm[i] / 2) / s[i] != zip[i]) {
      printf("%d\n", zip[i]);
      des = true;
      break;
    }
  }
  if (!des) printf("%d\n", zip[in]);
  return 0;
}
