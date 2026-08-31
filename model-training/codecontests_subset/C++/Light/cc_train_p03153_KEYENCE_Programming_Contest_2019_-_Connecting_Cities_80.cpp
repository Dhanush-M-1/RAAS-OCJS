//Link : https://atcoder.jp/contests/keyence2019/tasks/keyence2019_e

#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define N 200000
#define inf 2000000000000000000
int A[N];
pair<ll,int> seg1[N*4],seg2[N*4];

int n;
ll d;
void init(int pos,int l,int r) {
    if(l==r) {
        seg1[pos] = make_pair((ll)l*d + A[l],l);
        seg2[pos] = make_pair(-(ll)l*d + A[l],l);
        return;
    }
    int mid = (l+r)/2;
    init(pos*2,l,mid);
    init(pos*2+1,mid+1,r);
    seg1[pos] = min(seg1[pos*2],seg1[pos*2+1]);
    seg2[pos] = min(seg2[pos*2],seg2[pos*2+1]);
}
pair<ll,int> query(pair<ll,int> *seg,int pos,int l,int r,int ql,int qr) {
    if(r<ql || qr<l) {
        return make_pair(inf,0);
    }
    if(ql<=l && r<=qr) {
        return seg[pos];
    }
    int mid = (l+r)/2;
    return min(query(seg,pos*2,l,mid,ql,qr),query(seg,pos*2+1,mid+1,r,ql,qr));
}

ll solveSeg(int l,int r,ll leftValue,ll rightValue) {
    if(l>r) {
        return 0;
    }
    ll ret = 0;
    int index = -1;ll value = inf;
    pair<ll,int> q = query(seg1,1,0,n-1,l,r);
    index = q.second;
    value = q.first + leftValue;
    q = query(seg2,1,0,n-1,l,r);
    int tindex = q.second;
    if(q.first + rightValue < value) {
        value = q.first + rightValue;
        index = q.second;
    }
    ll u = min(rightValue, A[index] + d*index);
    ll v = min(leftValue,  A[index] - d*index);
    ret += solveSeg(l,index-1,leftValue,u)
        +  solveSeg(index+1,r,v,rightValue) + value;
    return ret;
}
void solve() {
    scanf("%d %lld",&n,&d);
    int minIndex = -1,minValue = 2e9;
    for(int i=0;i<n;++i) {
        scanf("%d",&A[i]);
        if(A[i]<minValue) {
            minValue  = A[i];
            minIndex = i;
        }
    }
    init(1,0,n-1);
    printf("%lld\n",solveSeg(0,minIndex-1,inf,minIndex*d + A[minIndex])
                    + solveSeg(minIndex+1,n-1,-minIndex*d + A[minIndex],inf)
    );
}

int main() {
    //freopen("input.txt","r",stdin);
    solve();
    return 0;
}
