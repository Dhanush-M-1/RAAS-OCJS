#include <bits/stdc++.h>

using namespace std;

#define int long long
#define all(v) begin(v), end(v)
#define rep(i, n) for(int i = 0; i < (int)(n); i++)
#define reps(i, s, n) for(int i = (int)(s); i < (int)(n); i++)

const int inf = 1LL << 55;
const int mod = 1e9 + 7;

int n;
int bit[400];

int dx[] = {0, 0, 1, 0, -1, 0, 2, 0, -2};
int dy[] = {0, 1, 0, -1, 0, 2, 0, -2, 0};

map<pair<int, vector<int> >, bool> mp;

bool in(int x, int y) {
  return 0 <= x && x < 3 && 0 <= y && y < 3;
}

bool dfs(int day, vector<int> v) {
  if(mp.count(make_pair(day, v))) return mp[make_pair(day, v)];
  if(day == n) return true;
  int x = v[0]%3, y = v[0]/3;
  for(int i = 0; i < 9; i++) {
    vector<int> nv(7);
    int tmp = 0;
    int nx = x + dx[i], ny = y + dy[i];
    if(!in(nx, ny)) continue;
    tmp = 1<<(ny*4+nx) | 1<<((ny+1)*4+nx) | 1<<(ny*4+nx+1) | 1<<((ny+1)*4+nx+1);
    if(bit[day+1] & tmp) continue;
    int a[16] = {0}; 
    for(int i = 0; i < 6; i++) nv[i+1] = v[i];    
    nv[0] = ny*3 + nx;
    if(day >= 5) {      
      for(int j = 0; j < 7; j++) {
	int tx = nv[j]%3, ty = nv[j]/3;
	a[ty*4+tx]++;
	a[(ty+1)*4+tx]++;
	a[ty*4+tx+1]++;
	a[(ty+1)*4+tx+1]++;
      }
      bool flag = true;
      for(int j = 0; j < 16; j++) {
	flag &= (a[j] != 0);
      }
      if(!flag) continue;
    }
    if(dfs(day+1, nv)) return mp[make_pair(day, v)] = true;
  }
  return mp[make_pair(day, v)] = false;
}

signed main() {
  cin.tie(0);
  ios_base::sync_with_stdio(0);
  cout << fixed << setprecision(12);

  while(cin >> n, n) {
    mp.clear();
    for(int i = 0; i < n; i++) {
      bit[i] = 0;
      for(int j = 0; j < 16; j++) {
	int b; cin >> b;
	bit[i] |= b<<j;
      }
    }
    int tmp = 0;
    tmp = 1<<5 | 1<<6 | 1<<9 | 1<<10;
    if(bit[0] & tmp) {
      cout << 0 << endl;
      continue;
    }
    vector<int> v(7, -1);
    v[0] = 4;
    cout << (int)dfs(0, v) << endl;
  }
  
  
  return 0;
}