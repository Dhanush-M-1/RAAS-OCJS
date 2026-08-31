#include <bits/stdc++.h>
using namespace std;
const int dr[] = {1, 0, -1, 0, 1, 1, -1, -1};
const int dc[] = {0, 1, 0, -1, 1, -1, -1, 1};
const double eps = 1e-9;
const int INF = 0x7FFFFFFF;
const long long INFLL = 0x7FFFFFFFFFFFFFFFLL;
const double pi = acos(-1);
template <class T>
T take(queue<T> &O) {
  T tmp = O.front();
  O.pop();
  return tmp;
}
template <class T>
T take(stack<T> &O) {
  T tmp = O.top();
  O.pop();
  return tmp;
}
template <class T>
T take(priority_queue<T> &O) {
  T tmp = O.top();
  O.pop();
  return tmp;
}
template <class T>
inline void getint(T &num) {
  bool neg = 0;
  num = 0;
  char c;
  while ((c = getchar_unlocked()) && (!isdigit(c) && c != '-'))
    ;
  if (c == '-') {
    neg = 1;
    c = getchar_unlocked();
  }
  do num = num * 10 + c - '0';
  while ((c = getchar_unlocked()) && isdigit(c));
  num *= (neg) ? -1 : 1;
}
void OPEN(string in = "input.txt", string out = "output.txt") {
  freopen(in.c_str(), "r", stdin);
  freopen(out.c_str(), "w", stdout);
  return;
}
int a, b, ans;
int main() {
  getint(a);
  getint(b);
  ans += a;
  int c = b;
  while (a / b) {
    ans += a / b;
    a = a / b + a % b;
  }
  printf("%d\n", ans);
  return 0;
}
