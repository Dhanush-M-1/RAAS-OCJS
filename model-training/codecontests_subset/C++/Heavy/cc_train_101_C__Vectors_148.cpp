#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:167177216")
using namespace std;
const int MAX = 2147483647;
const int MAXN = 200100;
const long long MOD = 1000000000 + 7;
vector<long long> t(MAXN, -2000000000);
long long n, k, b, c;
vector<long long> tmp(MAXN);
pair<bool, long long> check(int val) {
  long long ans = 0;
  int idx = 0;
  bool inited = false;
  for (int i = 0; i < n; ++i) {
    if (t[i] > val) continue;
    if (!inited && (n - i) < k) return make_pair(false, 1000000000000000000);
    inited = true;
    long long need = val - t[i];
    long long cost;
    if (5 * c <= b) {
      cost = (long long)need * c;
    } else {
      cost = (need / (long long)5) * b + (need % (long long)5) * c;
    }
    tmp[idx++] = cost;
  }
  sort(tmp.begin(), tmp.begin() + idx);
  for (int i = 0; i < k; ++i) {
    ans += tmp[i];
  }
  return make_pair(true, ans);
}
int main(int argc, char* argv[]) {
  long long ax, ay, bx, by, cx, cy;
  cin >> ax >> ay >> bx >> by >> cx >> cy;
  long long dx = bx - ax;
  long long dy = by - ay;
  cx = cx;
  cy = cy;
  if (dx == cx && dy == cy || (dx == cy && dy == cx)) {
    cout << "YES";
    return 0;
  }
  long long D = cx * cx + cy * cy;
  long long AD = dx * cx + dy * cy;
  long long BD = cx * dy - cy * dx;
  if (D != 0 && AD % D == 0 && BD % D == 0) {
    cout << "YES";
    return 0;
  }
  dx = bx + ay;
  dy = by - ax;
  cx = cx;
  cy = cy;
  if (dx == cx && dy == cy || (dx == cy && dy == cx)) {
    cout << "YES";
    return 0;
  }
  D = cx * cx + cy * cy;
  AD = dx * cx + dy * cy;
  BD = cx * dy - cy * dx;
  if (D != 0 && AD % D == 0 && BD % D == 0) {
    cout << "YES";
    return 0;
  }
  dx = bx - ay;
  dy = by + ax;
  cx = cx;
  cy = cy;
  if (dx == cx && dy == cy || (dx == cy && dy == cx)) {
    cout << "YES";
    return 0;
  }
  D = cx * cx + cy * cy;
  AD = dx * cx + dy * cy;
  BD = cx * dy - cy * dx;
  if (D != 0 && AD % D == 0 && BD % D == 0) {
    cout << "YES";
    return 0;
  }
  dx = bx + ax;
  dy = by + ay;
  cx = cx;
  cy = cy;
  if (dx == cx && dy == cy || (dx == cy && dy == cx)) {
    cout << "YES";
    return 0;
  }
  D = cx * cx + cy * cy;
  AD = dx * cx + dy * cy;
  BD = cx * dy - cy * dx;
  if (D != 0 && AD % D == 0 && BD % D == 0) {
    cout << "YES";
    return 0;
  }
  cout << "NO";
  return 0;
}
