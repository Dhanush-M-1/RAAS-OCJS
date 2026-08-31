#include <bits/stdc++.h>
using namespace std;
int n, cntr = 0;
;
priority_queue<int> V1, V2, V3, V4;
int main() {
  cin >> n;
  for (int i = 0, a; i < n; i++) {
    cin >> a;
    V1.push(a);
  }
  for (int i = 0, a; i < n - 1; i++) {
    cin >> a;
    V2.push(a);
    V4.push(a);
  }
  for (int i = 0, a; i < n - 2; i++) {
    cin >> a;
    V3.push(a);
  }
  for (int i = 0; i < n - 1; i++)
    if (V1.top() == V2.top()) {
      V1.pop();
      V2.pop();
    }
  cout << V1.top() << endl;
  for (int i = 0; i < n - 2; i++)
    if (V4.top() == V3.top()) {
      V4.pop();
      V3.pop();
    }
  cout << V4.top() << endl;
  return 0;
}
