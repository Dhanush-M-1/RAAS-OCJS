#include<iostream>
#define DIM 100005
using namespace std;
int x, n, q, t, val, sol, u, i, sum;
int v[DIM], a[DIM], amax[DIM], vmin[DIM];
int main(){
    cin>> x >> n;
    for(i = 1; i <= n; i++){
        cin>> v[i];
    }
    amax[0] = x;
    for(i = 1; i <= n; i++){
        if(i % 2 == 1){
            a[i] = max(0, a[i - 1] - (v[i] - v[i - 1]) );
            amax[i] = max(0, amax[i - 1] - (v[i] - v[i - 1]) );
            sum -= v[i] - v[i - 1];
        }
        else{
            a[i] = min(x, a[i - 1] + v[i] - v[i - 1]);
            amax[i] = min(x, amax[i - 1] + v[i] - v[i - 1]);
            sum += v[i] - v[i - 1];
        }
        vmin[i] = min(vmin[i - 1], sum);
    }
    v[n + 1] = 1000000001;
    u = 0;
    cin>> q;
    for(; q; q--){
        cin>> t >> val;
        while(v[u + 1] <= t){
            u++;
        }
        sol = min(a[u] + max(0, val + vmin[u]), amax[u]);
        if(u % 2 == 1){
            sol = min(x, sol + t - v[u]);
        }
        else{
            sol = max(0, sol - (t - v[u]) );
        }
        cout<< sol <<"\n";
    }
    return 0;
}
