#include <bits/stdc++.h>
template <class V>
int get_p(V& p, int j) {
  if (p[j] == j) return j;
  if (p[j] < 0) return p[j] = -get_p(p, -p[j]);
  return p[j] = get_p(p, p[j]);
}
int get_min(bool a_j, int S_j, bool coa_j, int coS_j) {
  if (!coa_j) return S_j;
  if (!a_j) return coS_j;
  return std::min(S_j, coS_j);
}
void proc() {
  int n, k;
  std::cin >> n >> k;
  std::vector<bool> x(n);
  for (int i = 0; i < n; i++) {
    char c;
    std::cin >> c;
    x[i] = c % 2;
  }
  std::vector<std::vector<int> > J(n);
  std::vector<int> p(k + 1);
  for (int j = 1; j <= k; j++) {
    p[j] = j;
    int c;
    std::cin >> c;
    while (c--) {
      int i;
      std::cin >> i;
      J[i - 1].push_back(j);
    }
  }
  std::vector<int> S(k + 1, 1);
  std::vector<int> coS(k + 1, 0);
  std::vector<bool> a(k + 1, true);
  std::vector<bool> coa(k + 1, true);
  int R = 0;
  for (int i = 0; i < n; i++) {
    if (J[i].size() == 0) {
      std::cout << R << std::endl;
      continue;
    }
    int j = J[i][0];
    int p_j = get_p(p, j);
    int abs_p_j = std::abs(p_j);
    bool a_j = a[abs_p_j];
    bool coa_j = coa[abs_p_j];
    int S_j = S[abs_p_j];
    int coS_j = coS[abs_p_j];
    if (J[i].size() == 1) {
      a[abs_p_j] = a_j & (x[i] ^ (p_j > 0));
      coa[abs_p_j] = coa_j & (x[i] ^ (p_j < 0));
      int m_0 = get_min(a_j, S_j, coa_j, coS_j);
      int m_1 = get_min(a[abs_p_j], S_j, coa[abs_p_j], coS_j);
      R += m_1 - m_0;
      std::cout << R << std::endl;
      continue;
    }
    int l = J[i][1];
    int p_l = get_p(p, l);
    int abs_p_l = std::abs(p_l);
    bool a_l = a[abs_p_l];
    bool coa_l = coa[abs_p_l];
    int S_l = S[abs_p_l];
    int coS_l = coS[abs_p_l];
    if (abs_p_j < abs_p_l) {
      std::swap(p_j, p_l);
      std::swap(abs_p_j, abs_p_l);
      std::swap(a_j, a_l);
      std::swap(coa_j, coa_l);
      std::swap(S_j, S_l);
      std::swap(coS_j, coS_l);
    }
    a[abs_p_j] = a_j & coa_l ^
                 (a_j & coa_l ^ a_j & a_l) & (x[i] ^ (p_j > 0) ^ (p_l > 0));
    coa[abs_p_j] = coa_j & a_l ^ (coa_j & a_l ^ coa_j & coa_l) &
                                     (x[i] ^ (p_j > 0) ^ (p_l > 0));
    int m_0 = get_min(a_j, S_j, coa_j, coS_j);
    if (abs_p_j != abs_p_l) {
      m_0 += get_min(a_l, S_l, coa_l, coS_l);
      bool t = x[i] ^ (p_j > 0) ^ (p_l > 0);
      p[abs_p_l] = t ? abs_p_j : -abs_p_j;
      S[abs_p_j] += t ? S_l : coS_l;
      coS[abs_p_j] += t ? coS_l : S_l;
    }
    int m_1 = get_min(a[abs_p_j], S[abs_p_j], coa[abs_p_j], coS[abs_p_j]);
    R += m_1 - m_0;
    std::cout << R << std::endl;
  }
}
int main() {
  std::cin.tie(0);
  std::cin.sync_with_stdio(false);
  int t = 1;
  while (t--) proc();
  return 0;
}
