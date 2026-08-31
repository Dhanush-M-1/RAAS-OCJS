#include <cstdio>
int main(){
    int a,b,c;
    std::scanf("%d %d %d",&a,&b,&c);
    std::puts(((a+b==c)||(b+c==a)||(c+a==b))?"Yes":"No");
}