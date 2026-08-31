#include <bits/stdc++.h>
using namespace std;
void solve();
void fast() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
}
template <typename T>
istream &operator>>(istream &in, vector<T> &ans) {
  for (auto &d : ans) in >> d;
  return in;
}
template <typename T>
ostream &operator<<(ostream &out, vector<T> &ans) {
  for (auto &d : ans) out << d << " ";
  return out;
}
signed main() {
  fast();
  solve();
}
struct node {
  int key;
  long long y;
  int sz;
  node *left, *right;
  node(int _key) : key(_key) {
    key = _key;
    y = rand();
    sz = 1;
    left = nullptr;
    right = nullptr;
  }
};
int size(node *v) { return (v == nullptr) ? 0 : v->sz; }
void upd(node *v) { v->sz = size(v->left) + size(v->right) + 1; }
pair<node *, node *> split_key(node *root, int c) {
  if (root == nullptr) return {nullptr, nullptr};
  if (root->key > c) {
    auto p = split_key(root->left, c);
    root->left = p.second;
    upd(root);
    return {p.first, root};
  } else {
    auto p = split_key(root->right, c);
    root->right = p.first;
    upd(root);
    return {root, p.second};
  }
}
pair<node *, node *> split_size(node *root, int c) {
  if (root == nullptr) return {nullptr, nullptr};
  if (size(root->left) >= c) {
    auto p = split_size(root->left, c);
    root->left = p.second;
    upd(root);
    return {p.first, root};
  } else {
    auto p = split_size(root->right, c - size(root->left) - 1);
    root->right = p.first;
    upd(root);
    return {root, p.second};
  }
}
node *merge(node *a, node *b) {
  if (a == nullptr) return b;
  if (b == nullptr) return a;
  if (a->y > b->key) {
    a->right = merge(a->right, b);
    upd(a);
    return a;
  } else {
    b->left = merge(a, b->left);
    upd(b);
    return b;
  }
}
node *insert(node *root, int ke) {
  auto p = split_key(root, ke);
  return merge(merge(p.first, new node(ke)), p.second);
}
struct qur {
  int k, pos, numb;
};
bool operator<(qur a, qur b) { return a.k < b.k; }
void print(node *root) {
  if (root == nullptr) return;
  print(root->left);
  cout << root->key << " ";
  print(root->right);
}
void solve() {
  int n;
  cin >> n;
  srand(time(0));
  vector<pair<int, int>> ans(n), pas;
  for (int i = 0; i < n; ++i) cin >> ans[i].first, ans[i].second = i;
  int m;
  cin >> m;
  vector<qur> kes(m);
  pas = ans;
  for (int i = 0; i < m; ++i) cin >> kes[i].k >> kes[i].pos, kes[i].numb = i;
  auto cmp = [](pair<int, int> a, pair<int, int> b) {
    if (a.first != b.first) return a.first > b.first;
    return a.second < b.second;
  };
  sort(kes.begin(), kes.end());
  sort(ans.begin(), ans.end(), cmp);
  int cnt = 0;
  vector<int> otv(m);
  node *root = nullptr;
  for (auto &[k, pos, numb] : kes) {
    while (cnt < k) root = insert(root, ans[cnt].second), cnt++;
    auto p = split_size(root, pos - 1);
    auto c = split_size(p.second, 1);
    otv[numb] = pas[c.first->key].first;
    root = merge(p.first, merge(c.first, c.second));
  }
  for (auto &d : otv) cout << d << endl;
}
