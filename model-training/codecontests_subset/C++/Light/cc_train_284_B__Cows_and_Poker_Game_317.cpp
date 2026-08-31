#include <bits/stdc++.h>
using namespace std;
void play() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
int arr[3];
int main() {
  play();
  int n;
  string s;
  cin >> n >> s;
  for (int j = 0; j < n; j++) {
    if (s[j] == 'I')
      arr[0]++;
    else if (s[j] == 'A')
      arr[1]++;
  }
  if (arr[0] == 0)
    cout << arr[1];
  else if (arr[0] == 1)
    cout << 1;
  else
    cout << 0;
  return 0;
}
