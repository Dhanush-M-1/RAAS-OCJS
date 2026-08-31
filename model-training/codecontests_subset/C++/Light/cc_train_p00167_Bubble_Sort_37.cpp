#include <iostream>

#define reep(i,n,m) for(int i=(n);i<(m);i++)
#define rep(i,n) reep(i,0,n)

using namespace std;

int main(){
    int n;
    while(cin>>n,n){
        int a[101]={0};
        rep(i,n){
            cin >> a[i];
        }

        int ans=0;
        rep(i,n){
            rep(i,n-1){
                if(a[i]>a[i+1]){
                    swap(a[i],a[i+1]);
                    ans++;
                }
            }
        }

        cout << ans << endl;
    }
    return 0;
}