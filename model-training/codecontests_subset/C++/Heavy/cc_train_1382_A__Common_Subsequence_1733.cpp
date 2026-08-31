#include <bits/stdc++.h>
using namespace std;
bool comp(int a, int b) { return a < b; }
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  int64_t t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    bool flag = true;
    int first[n];
    for (int i = 0; i < n; i++) cin >> first[i];
    int second[m];
    for (int i = 0; i < m; i++) cin >> second[i];
    std::vector<int> v1(1000, 0);
    std::vector<int>::iterator it;
    std::sort(first, first + n);
    std::sort(second, second + m);
    it =
        std::set_intersection(first, first + n, second, second + m, v1.begin());
    v1.resize(it - v1.begin());
    if (v1.size() > 0)
      cout << "YES\n" << 1 << " " << *min_element(v1.begin(), v1.end()) << '\n';
    else
      cout << "NO\n";
  }
}
