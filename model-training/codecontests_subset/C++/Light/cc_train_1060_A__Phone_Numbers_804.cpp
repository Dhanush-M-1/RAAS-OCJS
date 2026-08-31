#include <bits/stdc++.h>
using namespace std;
template <class T>
void BubbleSort(T ar[], T size) {
  for (int i = 0; i < size; i++) {
    for (int j = size - 1; j > i; j--) {
      if (ar[j] < ar[j - 1]) swap(ar[j], ar[j - 1]);
    }
  }
}
int GCD(int n, int m) { return (m ? GCD(m, n % m) : n); }
int main() {
  int n;
  string s1;
  cin >> n >> s1;
  int sum = 0, del;
  for (int i = 0; i < s1.size(); i++) {
    if (s1[i] == '8') sum++;
  }
  del = s1.size() / 11;
  cout << min(sum, del);
  return 0;
}
