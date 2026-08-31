#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int arr[26] = {0};
  multimap<int, char> mp;
  int flag = 0;
  for (int i = 0; i < s.length(); i++) {
    arr[s[i] - 'a']++;
  }
  for (int i = 0; i < 26; i++) {
    if (arr[i] % n != 0) {
      flag = 1;
    }
  }
  if (flag)
    cout << -1 << endl;
  else {
    int j = 0;
    for (int i = 0; i < 26; i++) {
      if (arr[i] != 0) {
        int p = arr[i] / n;
        for (int x = 0; x < p; x++) {
          s[j++] = i + 'a';
        }
      }
    }
    for (int j = 0; j < n; j++) {
      for (int i = 0; i < s.length() / n; i++) {
        cout << s[i];
      }
    }
    cout << endl;
  }
}
