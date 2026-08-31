#include<cstdio>
#include<algorithm>
int main(){
    int n,m,a[50],b[50],c[50],d[50];
    scanf("%d%d",&n,&m);
    for(int i=0;i<n;i++)scanf("%d%d",&a[i],&b[i]);
    for(int i=0;i<m;i++)scanf("%d%d",&c[i],&d[i]);
    for(int i=0;i<n;i++){
        int k,l=1e9,ans;
        for(int j=0;j<m;j++){
            k=std::abs(a[i]-c[j])+std::abs(b[i]-d[j]);
            if(k<l){
                ans=j+1;
                l=k;
            }
        }
        printf("%d\n",ans);
    }
    return 0;
}