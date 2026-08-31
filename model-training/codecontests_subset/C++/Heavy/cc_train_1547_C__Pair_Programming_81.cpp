#include <bits/stdc++.h>
#include <cstdio>
#define FAST_IO ios_base::sync_with_stdio(false);cin.tie(0);cout.tie(0);cerr.tie(0)
#define pb push_back
#define all(x) begin(x), end(x)
#define umap unordered_map
#define TEST_CASES int a; cin >> a; for (int i = 0; i < a; i++) {solve(); cout << endl;}
using namespace std;
typedef long long ll;
typedef long double ld;
template<typename T>
int binary_search(vector<T> &vec, T n) {
    int l = vec.size();
    int left = 0;
    int right = l - 1;
    while (left != right) {
        int mid = (left + right + 1) / 2;
        if (vec[mid] > n) right = mid - 1;
        else left = mid;
    }
    return vec[left] == n ? left : -1;
}
ll bs_lowest(const function<bool(ll)> &f, ll lo, ll hi) {
    while (lo < hi) {
        ll m = (lo+hi)/2;
        f(m) ? hi = m : lo = m+1;
    }
    return lo;
}
ll bs_highest(const function<bool(ll)> &f, ll lo, ll hi) {
    while (lo < hi) {
        ll m = (lo+hi+1)/2;
        f(m) ? lo = m : hi = m-1;
    }
    return lo;
}
vector<string> split(const string& str, const string& delim) {
    vector<string> tokens;
    size_t prev = 0, pos = 0;
    do {
        pos = str.find(delim, prev);
        if (pos == string::npos) pos = str.length();
        string token = str.substr(prev, pos-prev);
        if (!token.empty()) tokens.push_back(token);
        prev = pos + delim.length();
    }
    while (pos < str.length() && prev < str.length());
    return tokens;
}
struct cow {
    int l, r;
};
bool cmp(const cow&x, const cow&y){
    if (x.r != y.r){
        return x.r < y.r;
    }
    return x.l < y.l;
}
void solve() {
    int b, c, d; cin >> b >> c >> d;
    vector<int> vec(c);
    vector<int> vect(d);
    for (int i = 0; i < c; i++){
        cin >> vec[i];
    }
    for (int i = 0; i < d; i++){
        cin >> vect[i];
    }
    int first = 0; int second = 0;
    vector<int> ans;
    while (first < c && second < d){
        if (vec[first] == 0){
            b++; ans.pb(vec[first]); first++;
        }
        else if (vect[second] == 0){
            b++; ans.pb(vect[second]); second++;
        }
        else if (vec[first] <= b){
            ans.pb(vec[first]); first++;
        }
        else if (vect[second] <= b){
            ans.pb(vect[second]); second++;
        }
        else{
            cout << -1; return;
        }
    }
    if (first < c){
        for (int i = first; i < c; i++){
            if (vec[i] == 0){
                b++; ans.pb(vec[i]);
            }
            else if (vec[i] <= b){
                ans.pb(vec[i]);
            }
            else{
                cout << -1; return;
            }
        }
    }
    if (second < d){
        for (int i = second; i < d; i++){
            if (vect[i] == 0){
                b++; ans.pb(vect[i]);
            }
            else if (vect[i] <= b){
                ans.pb(vect[i]);
            }
            else{
                cout << -1; return;
            }
        }
    }
    for (int i = 0; i < ans.size(); i++){
        cout << ans[i] << " ";
    }
}
int main() {
    FAST_IO;
    //freopen("helpcross.in", "r", stdin);
    //freopen("helpcross.out", "w", stdout);
    TEST_CASES;
    //solve(); cout << endl;
}