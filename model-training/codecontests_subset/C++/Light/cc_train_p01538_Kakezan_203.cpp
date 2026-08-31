#include<cstdio>
#include<vector>
#include<algorithm>
using namespace std;
int main(){
    int q;
    scanf("%d",&q);
    while(q--){
        bool memo[1000001];
        fill(memo,memo+1000001,false);
        int n;
        scanf("%d",&n);
        for(int i=0;true;i++){
            if(n/10==0){
                printf("%d\n",i);
                break;
            }
            int ma=0;
            for(int j=10;n/j;j*=10){
                int v1=n/j,v2=n%j;
                ma=max(ma,v1*v2);
            }
            if(memo[ma]){
                puts("-1");
                break;
            }
            memo[ma]=true;
            n=ma;
        }
    }
    return 0;
}