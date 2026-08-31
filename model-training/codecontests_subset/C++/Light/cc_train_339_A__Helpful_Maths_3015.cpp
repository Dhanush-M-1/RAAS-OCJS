#include <bits/stdc++.h>
using namespace std;
int main() {
  string arr;
  cin >> arr;
  int len = arr.length();
  int i = 0;
  int j;
  j = (len + 1) / 2;
  int a[j];
  int k;
  k = 0;
  while (i <= len) {
    a[k] = arr.at(i);
    k++;
    i = i + 2;
  }
  sort(a, a + j);
  i = 0;
  k = 0;
  while (i <= len) {
    arr.at(i) = a[k];
    k++;
    i = i + 2;
  }
  cout << arr;
  return 0;
}
