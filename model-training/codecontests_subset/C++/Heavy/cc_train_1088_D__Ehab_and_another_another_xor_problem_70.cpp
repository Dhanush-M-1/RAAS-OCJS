#include <bits/stdc++.h>
using pii = std::pair<int, int>;
using pll = std::pair<long long, long long>;
std::map<pii, int> cache;
int prefix_a = 0, prefix_b = 0;
int ask(int m1, int m2) {
  m1 += prefix_a;
  m2 += prefix_b;
  if (cache.count({m1, m2})) return cache[{m1, m2}];
  std::cout << "?"
            << " " << m1 << " " << m2 << std::endl;
  std::cout.flush();
  int a;
  std::cin >> a;
  cache[{m1, m2}] = a;
  return a;
}
void ans() {
  std::cout << "!"
            << " " << prefix_a << " " << prefix_b << std::endl;
  std::cout.flush();
}
void same(int i) {
  for (int o = i; o >= 0; o--) {
    if (ask(1 << o, 0) == -1) {
      prefix_a += (1 << o);
      prefix_b += (1 << o);
    }
  }
}
void play(int i) {
  if (i < 0) return;
  if (ask(0, 0) == 0) return same(i);
  if (ask(0, 0) == -1) {
    int r1 = ask((1 << i), 0);
    if (r1 == 0) {
      prefix_b |= (1 << i);
      return play(i - 1);
    }
    int r2 = ask(0, (1 << i));
    if (r2 == 0) {
      prefix_b |= (1 << i);
      return same(i - 1);
    }
    if (r1 != r2) {
      if (r1 == -1) {
        prefix_a |= (1 << i);
        prefix_b |= (1 << i);
      }
      cache[{prefix_a, prefix_b}] = -1;
    }
    if (r1 == r2) {
      prefix_b |= (1 << i);
      cache[{prefix_a, prefix_b}] = r1;
    }
    return play(i - 1);
  }
  if (ask(0, 0) == 1) {
    int r1 = ask(0, (1 << i));
    if (r1 == 0) {
      prefix_a |= (1 << i);
      return play(i - 1);
    }
    int r2 = ask((1 << i), 0);
    if (r2 == 0) {
      prefix_a |= (1 << i);
      return same(i - 1);
    }
    if (r1 != r2) {
      if (r1 == 1) {
        prefix_a |= (1 << i);
        prefix_b |= (1 << i);
      }
      cache[{prefix_a, prefix_b}] = 1;
    }
    if (r1 == r2) {
      prefix_a |= (1 << i);
      cache[{prefix_a, prefix_b}] = r1;
    }
    return play(i - 1);
  }
}
int main() {
  std::ios::sync_with_stdio(false);
  play(29);
  ans();
  return 0;
}
