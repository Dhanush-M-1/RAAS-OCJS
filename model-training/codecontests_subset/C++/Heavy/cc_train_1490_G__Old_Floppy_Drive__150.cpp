#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

const int N = 2e5 + 10;
int n,m;
long long sum;
long long a[N];
vector<pair<long long,int>> v;
int minp[N];

long long solve(long long x){


    long long maxv = v[v.size() - 1].first;
    if(maxv < x && sum <= 0) return -1;

    if(x <= maxv){
        int l = 0,r = v.size() - 1;
        while(l < r){
            int mid = (l + r) / 2;
            if(v[mid].first < x) l = mid + 1;
            else r = mid;
        }

        return minp[l] - 1;
    }

    long long cnt = 0;
    if(sum > 0) cnt = (x - maxv) / sum;
    x -= sum * cnt;
    if(x > maxv){
        cnt++;
        x -= sum;
    }

    int l = 0,r = v.size() - 1;
    while(l < r){
        int mid = (l + r) / 2;
        if(v[mid].first < x) l = mid + 1;
        else r = mid;
    }

    return cnt * n + minp[l] - 1;
}

int main(){
    int t;scanf("%d",&t);
    int Kase = 0;
    while(t--){
        scanf("%d%d",&n,&m);
        sum = 0;
        for(int i = 1;i <= n; ++i){
            scanf("%lld",a + i);
            sum += a[i];
        }

        v.clear();
        long long tmp = 0;
        for(int i = 1;i <= n; ++i){
            tmp += a[i];
            v.push_back({tmp,i});
        }
        sort(v.begin(),v.end());

        minp[v.size()] = n + 1;
        for(int i = v.size() - 1;i >= 0 ;--i){
            minp[i] = min(minp[i + 1],v[i].second);
        }
//        for(int i = 0;i < v.size(); ++i) cout << minp[i] << " ";
//        cout << endl;

        for(int i = 0;i < m; ++i){
            long long x;scanf("%lld",&x);
            printf("%lld ",solve(x));
        }
        //printf("case: %d",++Kase);
        puts("");
    }

    return 0;
}
