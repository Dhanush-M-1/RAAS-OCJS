#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:36777216")
using namespace std;
int n, m;
int vis[110];
int temp;
int ans = 0;
int main(void) {
  cin >> n >> m;
  int num;
  for (int i = 0; i < n; i++) {
    cin >> num;
    for (int j = 0; j < num; j++) {
      scanf("%d", &temp);
      if (!vis[temp]) {
        ans++;
        vis[temp]++;
      }
    }
  }
  if (ans == m)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
