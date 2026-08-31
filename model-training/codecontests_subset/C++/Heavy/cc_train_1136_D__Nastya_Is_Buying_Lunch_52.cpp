#include <bits/stdc++.h>
using namespace std;
long long int p[300010];
set<long long int> a[300010];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int n, m, i, u, v, j;
  cin >> n >> m;
  for (i = 1; i <= n; i++) {
    cin >> p[i];
  }
  for (i = 0; i < m; i++) {
    cin >> u >> v;
    a[v].insert(u);
  }
  set<long long int> *cur_set = &a[p[n]];
  set<long long int> *new_set;
  long long int c = 0;
  for (j = n - 1; j >= 1; j--) {
    i = p[j];
    if (cur_set->count(i)) {
      c++;
    } else {
      new_set = new set<long long int>;
      set_intersection(cur_set->begin(), cur_set->end(), a[i].begin(),
                       a[i].end(), inserter(*new_set, new_set->begin()));
      swap(new_set, cur_set);
    }
  }
  cout << c << endl;
}
