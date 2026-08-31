#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int one;
    cin >> one;
    int two;
    cin >> two;
    int three;
    cin >> three;
    int num_a = min(one, two / 2) + min(two % 2, three / 2);
    int num_b = min(two, three / 2) + min((two - min(two, three / 2)) / 2, one);
    cout << max(num_a, num_b) * 3 << endl;
  }
}
