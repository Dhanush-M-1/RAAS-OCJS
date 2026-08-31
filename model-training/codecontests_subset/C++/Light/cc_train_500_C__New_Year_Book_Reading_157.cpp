#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:255777216")
using namespace std;
double PI = 3.1415926535897932384626433832795;
struct st {
  int w, id;
  st(int W, int Id) {
    w = W;
    id = Id;
  }
};
vector<st> p;
vector<int> a;
bool used[1 << 15];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    int w;
    cin >> w;
    p.push_back(st(w, i + 1));
  }
  for (int i = 0; i < m; i++) {
    int v;
    cin >> v;
    a.push_back(v);
  }
  int pos = 0;
  for (int i = 0; i < m; i++) {
    if (!used[a[i]]) {
      used[a[i]] = true;
      for (int j = pos; j < n; j++) {
        if (p[j].id == a[i]) {
          swap(p[j], p[pos]);
          break;
        }
      }
      pos++;
    }
  }
  long long answ = 0;
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      if (p[j].id != a[i]) {
        answ += p[j].w;
      } else {
        for (int k = j - 1; k >= 0; k--) swap(p[k], p[k + 1]);
        break;
      }
    }
  }
  cout << answ << endl;
  return 0;
}
