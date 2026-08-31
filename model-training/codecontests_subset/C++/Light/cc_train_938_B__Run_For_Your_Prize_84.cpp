#include <bits/stdc++.h>
using namespace std;
int arr[1000006];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  int ami = 1;
  int frnd = 1000000;
  int sec = 0;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  int lpos = 0;
  int upos = n - 1;
  while (lpos <= upos) {
    int x = arr[lpos] - ami;
    int y = frnd - arr[upos];
    if (lpos == upos) {
      sec += min(x, y);
      break;
    }
    if (y > x)
      lpos++;
    else
      upos--;
  }
  cout << sec << "\n";
  return 0;
}
