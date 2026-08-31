#include <bits/stdc++.h>
using namespace std;
int main() {
  int arr[26] = {0};
  int k;
  scanf("%d", &k);
  string x;
  cin >> x;
  int c = 0;
  for (int i = 0; i < x.size(); ++i) {
    arr[x[i] - 'a']++;
    ++c;
  }
  for (int i = 0; i < 25; ++i) {
    if (arr[i] % k == 0) {
    } else {
      cout << -1;
      return 0;
    }
  }
  if (c < k || c % k != 0) {
    cout << -1;
    return 0;
  }
  for (int i = 0; i < k; ++i) {
    for (int j = 0; j < 26; ++j) {
      for (int y = 0; y < arr[j] / k; ++y) {
        cout << (char)('a' + j);
      }
    }
  }
  return 0;
}
