#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using pll = pair<ll, ll>;
static bool constexpr dbg = 0;
ll constexpr NM = 110;
ll n;
ll id;
bool used[NM];
bool tmp[NM];
map<ll, pll> id2info;
struct idcmp {
  bool operator()(ll id1, ll id2) {
    return id2info[id1].first < id2info[id2].first;
  }
};
set<ll, idcmp> ids;
ll alloc(ll arg) {
  ll ret = 0;
  for (ll i = 1; i <= n - arg + 1; ++i) {
    if (none_of(&used[i], &used[i + arg], [](bool b) { return b; })) {
      ret = ++id;
      for (ll j = i; j < i + arg; ++j) used[j] = true;
      id2info[ret] = {i, arg};
      ids.insert(ret);
      break;
    }
  }
  return ret;
}
bool erase(ll i) {
  if (!id2info.count(i)) return false;
  for (ll j = id2info[i].first; j < id2info[i].first + id2info[i].second; ++j)
    used[j] = false;
  ids.erase(i);
  id2info.erase(i);
  return true;
}
void defra() {
  ll head = 1;
  for (auto curi : ids) {
    ll pstart = id2info[curi].first;
    ll curSize = id2info[curi].second;
    if (pstart > head) {
      for (ll i = pstart; i < pstart + curSize; ++i) used[i] = false;
      for (ll i = head; i < head + curSize; ++i) used[i] = true;
    }
    id2info[curi].first = head;
    head += curSize;
  }
}
int main() {
  if (!dbg) {
    std::ios::sync_with_stdio(false);
    cin.tie(nullptr);
  }
  ll t;
  cin >> t >> n;
  string cmd;
  for (ll _ = 1; _ <= (ll)(t); ++_) {
    cin >> cmd;
    if (cmd == "defragment") {
      defra();
      continue;
    }
    ll arg;
    cin >> arg;
    if (cmd == "alloc") {
      auto ret = alloc(arg);
      if (ret)
        cout << ret << '\n';
      else
        cout << "NULL\n";
    } else {
      if (!erase(arg)) cout << "ILLEGAL_ERASE_ARGUMENT\n";
    }
  }
  return 0;
}
