#include <bits/stdc++.h>
using namespace std;
void prob() {
  int n;
  cin >> n;
  int tw = 0;
  int hu = 0;
  for (int i = 0; i < n; i++) {
    int k;
    cin >> k;
    if (k == 100) {
      hu++;
    } else {
      tw++;
    }
  }
  tw = tw % 2;
  hu = hu - 2 * tw;
  if (hu % 2 == 0 && hu >= 0) {
    cout << "YES";
  } else {
    cout << "NO";
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int t = 1;
  while (t > 0) {
    prob();
    t--;
  }
  return 0;
}
