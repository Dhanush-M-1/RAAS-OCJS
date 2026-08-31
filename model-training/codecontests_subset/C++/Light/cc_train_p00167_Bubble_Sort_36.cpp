#include <stdio.h>
void swap(int &a,int &b){
    int temp=a;
    a=b;
    b=temp;
    return ;
}
const int N=1e5+10;
int main(){
    int n,a[N];
    while(true){
        scanf("%d",&n);
        if(n==0)return 0;
        for(int i=0;i<n;i++)scanf("%d",&a[i]);
        int ans=0;
        for(int i=0;i<n;i++)for(int j=0;j<n-1;j++)if(a[j]>a[j+1]){
            swap(a[j],a[j+1]);
            ans++;
        }
        printf("%d\n",ans);
    }
}
