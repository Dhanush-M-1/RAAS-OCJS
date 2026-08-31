#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e18;
namespace BF {
long long solve(int N, int M, int K, const vector<int>& T, const vector<int>& A,
                const vector<int>& B) {
  long long res = INF;
  for (int mask = 0, _n = (1 << N); mask < _n; ++mask) {
    if ((__builtin_popcount((mask))) != M) continue;
    int cntA = 0, cntB = 0;
    long long cur = 0;
    for (int i = 0, _n = (N); i < _n; ++i) {
      if (mask & (1 << i)) {
        if (A[i]) cntA++;
        if (B[i]) cntB++;
        cur += T[i];
      }
    }
    if (cntA >= K && cntB >= K) res = min(res, cur);
  }
  return res < INF ? res : -1;
}
}  // namespace BF
struct Item {
  int id, value;
  bool operator<(const Item i) const {
    if (value != i.value) return value < i.value;
    return id < i.id;
  }
  bool operator>(const Item i) const {
    if (value != i.value) return value > i.value;
    return id > i.id;
  }
};
ostream& operator<<(ostream& out, Item const& item) {
  return out << "(" << item.id << ':' << item.value << ")";
}
class MBest {
  long long best_sum;
  multiset<int, greater<int> > le;
  multiset<int> gt;
  void transfer_gt_to_le() {
    assert(!gt.empty());
    auto it = gt.begin();
    le.insert(*it);
    best_sum += *it;
    gt.erase(it);
  }
  void transfer_le_to_gt() {
    assert(!le.empty());
    auto it = le.begin();
    gt.insert(*it);
    best_sum -= *it;
    le.erase(it);
  }

 public:
  MBest() : best_sum(0) {}
  int getM() const { return le.size(); }
  long long query_best_sum() const { return best_sum; }
  void add(int x) {
    le.insert(x);
    best_sum += x;
    transfer_le_to_gt();
  }
  void remove(int x) {
    auto it_gt = gt.find(x);
    if (it_gt != gt.end()) {
      gt.erase(it_gt);
      return;
    }
    auto it_le = le.find(x);
    assert(it_le != le.end());
    le.erase(it_le);
    best_sum -= x;
    transfer_gt_to_le();
  }
  void increaseM() { transfer_gt_to_le(); }
};
vector<long long> get_psum(const vector<Item>& V) {
  vector<long long> res(int((V).size()));
  for (int i = (1), _b = (int((V).size()) - 1); i <= _b; ++i)
    res[i] = res[i - 1] + V[i].value;
  return res;
}
long long solve(int N, int M, int K, const vector<int>& T, const vector<int>& A,
                const vector<int>& B) {
  MBest mb;
  vector<Item> alice, bob, both;
  for (int i = 0, _n = (N); i < _n; ++i) {
    Item item = {i + 1, T[i]};
    if (A[i] && B[i])
      both.push_back(item);
    else if (A[i])
      alice.push_back(item);
    else if (B[i])
      bob.push_back(item);
    else
      mb.add(item.value);
  }
  int minj = min(int((alice).size()), int((bob).size()));
  if (minj + int((both).size()) < K) {
    cout << "-1" << '\n';
    return -1;
  }
  sort(alice.begin(), alice.end());
  sort(bob.begin(), bob.end());
  sort(both.begin(), both.end());
  minj = min(minj, K);
  for (int j = (minj), _b = (int((alice).size()) - 1); j <= _b; ++j)
    mb.add(alice[j].value);
  alice.erase(alice.begin() + minj, alice.end());
  alice.insert(alice.begin(), {0, 0});
  for (int j = (minj), _b = (int((bob).size()) - 1); j <= _b; ++j)
    mb.add(bob[j].value);
  bob.erase(bob.begin() + minj, bob.end());
  bob.insert(bob.begin(), {0, 0});
  both.insert(both.begin(), {0, 0});
  for (int k = (K - minj), _b = (int((both).size()) - 1); k <= _b; ++k)
    mb.add(both[k].value);
  vector<long long> psum_alice = get_psum(alice);
  vector<long long> psum_bob = get_psum(bob);
  vector<long long> psum_both = get_psum(both);
  long long res = INF;
  int bestj = -1;
  for (int j = minj; j >= 0; --j) {
    int k = K - j;
    if (k >= int((both).size())) break;
    mb.remove(both[k].value);
    int nbooks = K + j;
    if (nbooks <= M) {
      int nmissing = M - nbooks;
      while (mb.getM() < nmissing) mb.increaseM();
      long long best_other = mb.query_best_sum();
      long long cur = psum_alice[j] + psum_bob[j] + psum_both[k] + best_other;
      if (res > cur) {
        bestj = j;
        res = cur;
      }
    }
    if (j > 0) {
      mb.add(alice[j].value);
      mb.add(bob[j].value);
    }
  }
  if (bestj < 0) {
    cout << "-1\n";
    return -1;
  }
  set<Item> avail;
  for (int i = 0, _n = (N); i < _n; ++i) avail.insert({i + 1, T[i]});
  vector<int> best_books;
  for (int j = (1), _b = (bestj); j <= _b; ++j) {
    Item item = alice[j];
    avail.erase(item);
    best_books.push_back(item.id);
  }
  for (int j = (1), _b = (bestj); j <= _b; ++j) {
    Item item = bob[j];
    avail.erase(item);
    best_books.push_back(item.id);
  }
  for (int k = (1), _b = (K - bestj); k <= _b; ++k) {
    Item item = both[k];
    avail.erase(item);
    best_books.push_back(item.id);
  }
  assert(int((best_books).size()) <= M);
  while (int((best_books).size()) < M) {
    auto it = avail.begin();
    best_books.push_back(it->id);
    avail.erase(it);
  }
  cout << res << '\n';
  long long sum = 0;
  for (int id : best_books) {
    cout << id << ' ';
    sum += T[id - 1];
  }
  cout << '\n';
  return res;
}
int main(int argc, char* argv[]) {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int N, M, K;
  cin >> N >> M >> K;
  vector<int> T(N), A(N), B(N);
  for (int i = 0, _n = (N); i < _n; ++i) cin >> T[i] >> A[i] >> B[i];
  solve(N, M, K, T, A, B);
  return 0;
}
