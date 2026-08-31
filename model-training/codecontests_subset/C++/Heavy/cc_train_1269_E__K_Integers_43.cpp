#include <bits/stdc++.h>
using namespace std;
const int MAX = 2e5 + 5;
int a[MAX], p[MAX], n;
long long c1[MAX], c2[MAX];
set<int> st;
void add(long long *c, int x, int k) {
  for (; x <= n; x += x & -x) c[x] += k;
}
long long query(long long *c, int x) {
  long long sum = 0;
  for (; x; x -= x & -x) sum += c[x];
  return sum;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]), p[a[i]] = i;
  st.insert(p[1]);
  auto it = st.begin();
  printf("0 ");
  add(c1, p[1], 1);
  add(c2, p[1], p[1]);
  long long res = 0;
  for (int i = 2; i <= n; i++) {
    st.insert(p[i]);
    if (p[i] < (*it) && i % 2 == 0) it--;
    if (p[i] > (*it) && i % 2 == 1) it++;
    add(c1, p[i], 1);
    res += (i * 1ll - query(c1, p[i]));
    add(c2, p[i], p[i]);
    int midpos = *it;
    long long sum = 0, k = i / 2;
    sum += i & 1 ? k * (midpos - 1 + midpos - k) / 2
                 : (k - 1) * (midpos + midpos - k) / 2;
    sum -= k * (midpos + 1 + midpos + k) / 2;
    sum -= query(c2, midpos - 1);
    sum += query(c2, n) - query(c2, midpos);
    printf("%I64d ", res + sum);
  }
}
