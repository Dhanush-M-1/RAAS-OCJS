#include <bits/stdc++.h>
using namespace std;
long long arr[10002][9];
int main() {
  string ss;
  int k, n;
  int arr[30];
  for (int i = 0; i < 30; i++) arr[i] = 0;
  bool cn = false;
  cin >> k >> ss;
  for (int i = 0; i < ss.length(); i++) arr[ss[i] - 'a']++;
  for (int i = 0; i <= 25; i++) {
    if (arr[i] % k)
      cn = true;
    else
      arr[i] = arr[i] / k;
  }
  if (cn)
    cout << "-1\n";
  else {
    string tt = "";
    char ch;
    for (int i = 0; i <= 25; i++) {
      for (int j = 0; j < arr[i]; j++) {
        ch = i + 'a';
        tt += ch;
      }
    }
    string pp = "";
    for (int i = 0; i < k; i++) pp += tt;
    cout << pp << "\n";
  }
  return 0;
}
