# 1. Base image with Java
FROM maven:3.9.6-eclipse-temurin-17

# 2. Install Chrome
RUN apt-get update && apt-get install -y \
    wget \
    gnupg \
    unzip \
    && wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list \
    && apt-get update \
    && apt-get install -y google-chrome-stable \
    && rm -rf /var/lib/apt/lists/*

# 3. Set working directory
WORKDIR /app

# 4. Copy project
COPY . .

# 5. Download dependencies
RUN mvn clean dependency:resolve

# 6. Run tests
CMD ["mvn", "test"]