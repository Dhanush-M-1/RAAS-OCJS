#include <algorithm>
#include <cmath>
#include <functional>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <string>
#include <vector>
using namespace std;
typedef long long i64;
typedef long double ld;
typedef pair<i64, i64> P;
#define rep(i, s, e) for (int i = (s); i <= (e); i++)

int n, m;
vector<pair<int, bool>> edges[101010];

i64 w[101010];

int ord[101010];
int low[101010];


int main() {
  cin >> n >> m;
  rep(i, 1, n) cin >> w[i];
  rep(i, 1, m) {
    int a, b;
    cin >> a >> b;
    edges[a].emplace_back(b, false);
    edges[b].emplace_back(a, false);
  }

  int cou;

  vector<i64> dp(n + 1,0);

  function<void(int)> dfs = [&](int v){
    ord[v] = cou++;
    low[v] = ord[v];

    dp[v] = w[v];
    for(auto & to : edges[v])
    {
      if(ord[to.first] == 0)
      {
        to.second = true;
        dfs(to.first);
        low[v] = min(low[to.first],low[v]);

        dp[v] += dp[to.first];
      }
      else if(!to.second)
      {
        low[v] = min(low[v],ord[to.first]);
      }
    }
  };
  for(int i = 1;i <= n;i++)
  {
    if(ord[i] == 0)
    {
      cou = 1;
      dfs(i);
    }
  }
  i64 sum = 0;
  for(int i = 1;i <= n;i++) sum += w[i];


  for(int i = 1;i <= n;i++)
  {
    i64 ans = 0;
    if(ord[i] == 1)
    {
      for(auto & to : edges[i])
      {
        ans = max(ans,dp[to.first]);
      }
    }
    else
    {
      i64 MAX = 0;
      ans = sum - dp[i];
      for(auto& to : edges[i])
      {
        if(!to.second) continue;
        if(ord[i] <= low[to.first])
        {
          MAX = max(MAX,dp[to.first]);
        }
        else
        {
          ans += dp[to.first];
        }
      }
      ans = max(ans,MAX);
    }

    cout << ans << endl;
  }
}

