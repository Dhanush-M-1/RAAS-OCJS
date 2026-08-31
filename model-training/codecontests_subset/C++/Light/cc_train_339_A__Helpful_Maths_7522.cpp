#include <bits/stdc++.h>
using namespace std;
void quicksort(string& a, int beg, int end) {
  if (beg >= end) return;
  int p = a[(beg + end) / 2];
  int i = beg;
  int j = end;
  while (i <= j) {
    while (a[i] < p) ++i;
    while (a[j] > p) --j;
    if (i <= j) swap(a[i++], a[j--]);
  }
  quicksort(a, beg, j);
  quicksort(a, i, end);
}
int main() {
  string s;
  cin >> s;
  string numbers;
  for (int i = 0; i < s.size(); i += 2) numbers.push_back(s[i]);
  quicksort(numbers, 0, numbers.size() - 1);
  for (int i = 0; i < numbers.size() - 1; ++i) cout << numbers[i] << '+';
  cout << numbers[numbers.size() - 1];
  return 0;
}
