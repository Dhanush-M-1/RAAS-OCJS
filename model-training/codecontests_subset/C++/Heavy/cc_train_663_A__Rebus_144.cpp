#include <bits/stdc++.h>
using namespace std;
int assign(vector<int> &o, vector<char> &s, int n, int pos, int neg) {
  o.resize(s.size());
  if (pos >= neg) {
    if (pos > (neg + 1) * n) return n + 1;
    for (int i = 0; i < s.size(); ++i)
      if (s[i] == '+') o[i] = 1;
    int diff = pos;
    for (int i = 0; i < s.size(); ++i) {
      if (s[i] == '-') {
        o[i] = max(1, min(diff - neg + 1, n));
        --neg;
        diff -= o[i];
      }
    }
    return diff;
  }
  if (neg > pos * n) return n + 1;
  for (int i = 0; i < s.size(); ++i)
    if (s[i] == '-') o[i] = 1;
  int diff = -neg;
  for (int i = 0; i < s.size(); ++i) {
    if (s[i] == '+') {
      o[i] = max(1, min(-diff - pos + 1, n));
      --pos;
      diff += o[i];
    }
  }
  return diff;
}
int main() {
  int n;
  vector<char> s;
  int pos = 0, neg = 0;
  for (char a, b; scanf(" %c %c", &a, &b) == 2 && b != '='; s.push_back(b))
    (b == '+' ? pos : neg) += 1;
  scanf("%d", &n);
  vector<int> operators;
  int diff = assign(operators, s, n, pos, neg);
  if (diff < 0 || diff >= n)
    puts("Impossible");
  else {
    puts("Possible");
    printf("%d", n - diff);
    for (int i = 0; i < s.size(); ++i) printf(" %c %d", s[i], operators[i]);
    printf(" = %d\n", n);
  }
  return 0;
}
