#include <bits/stdc++.h>
using namespace std;
int arr[500];
int main() {
  string s1;
  cin >> s1;
  int k = 0;
  for (int i = 0; i < s1.length(); i++) {
    if (s1.at(i) == '+')
      continue;
    else
      arr[k++] = s1.at(i) - '0';
  }
  sort(arr, arr + k);
  for (int i = 0; i < k; i++) {
    if (i != k - 1)
      printf("%d+", arr[i]);
    else
      printf("%d", arr[i]);
  }
  cout << endl;
  return 0;
}
