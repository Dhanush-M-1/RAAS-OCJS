#include<iostream>
#include<string>
#include<algorithm>
using namespace std;

const int mod = 10000;
string x;
int m,memo[510][510][10][2][3];

int dp(int keta,int d,int bef,bool sml,int zig){
    
    if(keta == x.size()) return d==0;
    if(memo[keta][d][bef][sml][zig] != -1) return memo[keta][d][bef][sml][zig];
    
    int n = sml?9:(x[keta]-'0');
    int res = 0;
    for(int i=0;i<=n;i++){
        
        if(zig == 2){
            if(i == 0) res = ( res+dp(keta+1,(d*10+i)%m,i,sml|(i<n),2) )%mod;
            else{
                res = ( res+dp(keta+1,(d*10+i)%m,i,sml|(i<n),bef<i) )%mod;
                if(keta < x.size()-1) res = ( res+dp(keta+1,(d*10+i)%m,i,sml|(i<n),bef>i) )%mod;   
            }
            continue;
        }
        if(zig == 0 && i <= bef) continue;
        if(zig == 1 && bef <= i) continue;
        res = ( res+dp(keta+1,(d*10+i)%m,i,sml|(i<n),!zig) )%mod;
        
    }
    
    return memo[keta][d][bef][sml][zig] = res;
}

int main()
{
    string a,b;
    int ans;
    
    cin >> a >> b;
    cin >> m;
    
    x = b;
    fill_n(****memo,510*510*10*2*3,-1);
    ans = dp(0,0,0,0,2)+mod;
    
    for(int i=a.size()-1;i>=0;i--){
        if(a[i] == '0') a[i] = '9';
        else {
            a[i]--;
            break;
        }
    }
    
    x = a;
    fill_n(****memo,510*510*10*2*3,-1);
    ans -= dp(0,0,0,0,2);
    
    cout << ans%mod << endl;
    return 0;
}

