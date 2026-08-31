#include <bits/stdc++.h>
using namespace std;
int main() {
  int v1, v2, t;
  cin >> v1 >> v2 >> t;
  int v = v1 - v2;
  int answer = 0;
  if (v > 0) {
    answer = t * v / v2;
    if ((t * v) % v2 > 0) answer++;
  }
  cout << answer;
}
