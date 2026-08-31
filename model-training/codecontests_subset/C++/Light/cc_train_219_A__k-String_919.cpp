#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  string a;
  int k, i, arr[26];
  memset(arr, 0, sizeof(arr));
  cin >> k >> a;
  for (i = 0; i < a.size(); i++) {
    arr[a[i] - 'a']++;
  }
  for (i = 0; i < 26; i++) {
    if (arr[i] > 0 && arr[i] % k) {
      cout << "-1\n";
      return 0;
    }
    arr[i] /= k;
  }
  char temp;
  while (k--) {
    for (i = 0; i < 26; i++) {
      temp = 'a';
      if (arr[i]) {
        temp += i;
        for (int j = 0; j < arr[i]; j++) cout << temp;
      }
    }
  }
}
