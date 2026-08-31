#include <bits/stdc++.h>
using namespace std;
int arr[5];
int main() {
  int n;
  scanf("%d", &n);
  string s;
  cin >> s;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'A')
      arr[0]++;
    else if (s[i] == 'F')
      arr[1]++;
    else
      arr[2]++;
  }
  if (arr[2] == 0)
    cout << arr[0];
  else if (arr[2] == 1)
    cout << 1;
  else
    cout << 0;
}
