#include <bits/stdc++.h>
using namespace std;
int check_digit(int t){
    int res=0;
    while(t!=0){
        t/=10;
        res++;
    }
    return res;
}
int sol(int t){
    int cd=check_digit(t);
    int c10=10;
    int res=0;
    for(int i=1;i<cd;i++){
        int t1=t%c10;
        int t2=t/c10;
        res=max(res,t1*t2);
        c10*=10;
    }
    return res;
}
int main(void){
    // Your code here!
    int q;
    cin>>q;
    int n[110];
    for(int i=0;i<q;i++){
        cin>>n[i];
        int ans=0;
        while(n[i]/10!=0){
            n[i]=sol(n[i]);
            ans++;
        }
        cout<<ans<<endl;
    }
    return 0;
}
