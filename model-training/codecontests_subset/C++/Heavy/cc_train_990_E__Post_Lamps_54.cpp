#include <bits/stdc++.h>
using namespace std;
const int IO_MAXCHARS = 1 << 16;
char input_buffer[IO_MAXCHARS + 1];
struct FastReader {
  char *p, *q;
  FastReader() : p(input_buffer), q(input_buffer) {}
  char next_char() {
    if (p >= q) {
      p = input_buffer;
      q = p + fread(input_buffer, 1, IO_MAXCHARS, stdin);
      *q = '\0';
    }
    return *p++;
  }
  template <typename T = int>
  T next_num() {
    char c = firstnws();
    if (c == '-') {
      return -next_unum<T>();
    } else {
      --p;
      return next_unum<T>();
    }
  }
  void next_string(string &buff) {
    buff.clear();
    buff += firstnws();
    char c;
    while (!isspace(c = next_char())) {
      buff += c;
    }
  }
  string next_string() {
    string s;
    next_string(s);
    return s;
  }

 private:
  char firstnws() {
    char c;
    while (isspace(c = next_char()))
      ;
    return c;
  }
  template <typename T>
  T next_unum() {
    char c;
    T ret = firstnws() - '0';
    while (isdigit(c = next_char())) {
      ret = 10 * ret + (c - '0');
    }
    return ret;
  }
} reader;
const int MAXN = 1000000 + 3;
const long long INF = 1234567890123456LL;
int B[MAXN];
int prev_unblocked[MAXN];
int n;
long long calc(int range, long long cost) {
  int at = 0;
  long long ret = 0;
  while (at < n) {
    if (prev_unblocked[at] == -1) return INF;
    if (prev_unblocked[at] + range <= at) return INF;
    at = prev_unblocked[at] + range;
    ret += cost;
  }
  return ret;
}
int main() {
  n = reader.next_num();
  int blocks = reader.next_num();
  int ntypes = reader.next_num();
  for (int i = 0; i < blocks; ++i) {
    B[i] = reader.next_num();
  }
  int b = 0;
  for (int i = 0; i < n; ++i) {
    if (b < blocks && B[b] == i) {
      prev_unblocked[i] = (i == 0 ? -1 : prev_unblocked[i - 1]);
      ++b;
    } else {
      prev_unblocked[i] = i;
    }
  }
  vector<int> costs(ntypes);
  for (int i = 0; i < ntypes; ++i) {
    costs[i] = reader.next_num();
  }
  vector<pair<int, int>> types = {{ntypes, costs.back()}};
  for (int i = ntypes - 2; i >= 0; --i) {
    if (costs[i] < types.back().second) {
      types.emplace_back(i + 1, costs[i]);
    }
  }
  reverse(types.begin(), types.end());
  long long sol = INF;
  for (const auto &t : types) {
    sol = min(sol, calc(t.first, t.second));
  }
  printf("%I64d\n", sol == INF ? -1LL : sol);
}
