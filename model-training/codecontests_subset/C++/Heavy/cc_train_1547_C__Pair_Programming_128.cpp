#include <bits/stdc++.h>
using namespace std;
 
#define MAXN (int)(1e5 + 5)
#define MAXL 20
#define F first
#define S second
#define endl "\n"
#define MOD (lli)(1e9 + 9)
#define MOD2 (lli)(1e9 + 7)
#define lli long long int
#define sz(a) int(a.size())
#define DEBUG if (0) cout << "aqui" << endl;
#define PI 2 * acos(0.0)
typedef pair<int, lli> ii;
int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};
int dddx[] = {1, -1, 0, 0, 1, 1, -1, -1};
int dddy[] = {0, 0, 1, -1, 1, -1, 1, -1};

int t;

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  cin >> t;

  while(t--) {
    int k, n, m;
    cin >> k >> n >> m;
    vector<int> vec, vec2;

    for(int i=0;i<n;i++) {
      int a;
      cin >> a;
      vec.push_back(a);
    }

    for(int i=0;i<m;i++) {
      int a;
      cin >> a;
      vec2.push_back(a);
    }

    vector<int> ans;
    int a = 0, b = 0;
    bool nono = false;
    while(a < sz(vec) or b < sz(vec2)) {
      bool at = false;

      if(b < sz(vec2)) {
        if(!vec2[b] or (a < sz(vec) && vec2[b] < vec[a])) at = true;
      }

      if(!at && a < sz(vec)) {
        ans.push_back(vec[a]);
        a++;
      } else if(b < sz(vec2)) {
        ans.push_back(vec2[b]);
        b++;
      }
    }

    int atual = k;
    for(auto i : ans) {
      if(!i) atual++;
      else if(i > atual) nono = true;
    }


    if(nono) {
      cout << -1 << endl;
      continue;
    }

    for(auto i : ans) cout << i << " ";
    cout << endl;

  }


  return 0;
}