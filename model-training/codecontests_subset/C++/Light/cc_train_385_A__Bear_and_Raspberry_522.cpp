#include <bits/stdc++.h>
using namespace std;
const int VISITED = 1;
const int UNVISITED = -1;
const long long OO = 1e12;
const int OOI = 1e9;
int xdir[] = {1, -1, 0, 0};
int ydir[] = {0, 0, -1, 1};
void file() {}
int n, c, arr[100 + 9];
int main() {
  file();
  cin >> n >> c;
  for (int i = 0; i < n; i++) cin >> arr[i];
  int ans = 0;
  for (int i = 0; i < n - 1; i++) ans = max(arr[i] - arr[i + 1] - c, ans);
  cout << ans << endl;
  return 0;
}
