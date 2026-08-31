#include <bits/stdc++.h>
using namespace std;
int n;
unordered_set<long long int> db;
vector<int> X[100001];
vector<int> Y[100001];
int main() {
  scanf("%d", &n);
  long long int ans = 0;
  for (int i = 0; i < (int)(n); i++) {
    int x, y;
    scanf("%d %d", &x, &y);
    if (X[x].size() < Y[y].size()) {
      for (int i = 0; i < (int)(X[x].size()); i++) {
        int dy = X[x][i];
        int l = dy - y;
        if (db.count((((long long int)x + l << 20) | (y))) &&
            db.count((((long long int)x + l << 20) | (dy))))
          ans++;
        if (db.count((((long long int)x - l << 20) | (y))) &&
            db.count((((long long int)x - l << 20) | (dy))))
          ans++;
      }
    } else {
      for (int i = 0; i < (int)(Y[y].size()); i++) {
        int dx = Y[y][i];
        int l = dx - x;
        if (db.count((((long long int)x << 20) | (y + l))) &&
            db.count((((long long int)dx << 20) | (y + l))))
          ans++;
        if (db.count((((long long int)x << 20) | (y - l))) &&
            db.count((((long long int)dx << 20) | (y - l))))
          ans++;
      }
    }
    X[x].push_back(y);
    Y[y].push_back(x);
    db.insert((((long long int)x << 20) | (y)));
  }
  cout << ans << endl;
  return 0;
}
