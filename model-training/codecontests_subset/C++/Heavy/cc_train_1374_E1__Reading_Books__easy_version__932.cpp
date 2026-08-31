#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  priority_queue<int, vector<int>, greater<int>> ab;
  priority_queue<int, vector<int>, greater<int>> av;
  priority_queue<int, vector<int>, greater<int>> bv;
  int n, k;
  cin >> n >> k;
  int cntA, cntB;
  cntA = cntB = 0;
  for (int i = 0; i < n; i++) {
    int t, a, b;
    cin >> t >> a >> b;
    if (a == 1 && b == 1) {
      cntA++;
      cntB++;
      ab.push(t);
    } else if (a == 1) {
      cntA++;
      av.push(t);
    } else if (b == 1) {
      cntB++;
      bv.push(t);
    }
  }
  if (cntA < k || cntB < k) {
    cout << "-1" << endl;
    return 0;
  }
  int time = 0;
  while (k > 0) {
    if (!ab.empty() && !av.empty() && !bv.empty()) {
      if (ab.top() > av.top() + bv.top()) {
        time += av.top() + bv.top();
        av.pop();
        bv.pop();
        k--;
      } else {
        time += ab.top();
        ab.pop();
        k--;
      }
    } else {
      if (av.empty() || bv.empty()) {
        time += ab.top();
        ab.pop();
        k--;
      } else {
        time += av.top() + bv.top();
        av.pop();
        bv.pop();
        k--;
      }
    }
  }
  cout << time << endl;
  return 0;
}
